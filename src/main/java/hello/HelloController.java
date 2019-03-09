package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {

    private static final int MILLIS = 1;
    private static final int SECONDS = 1000;

    private AtomicInteger fastCounter = new AtomicInteger(0);
    private AtomicInteger mediumCounter = new AtomicInteger(0);
    private AtomicInteger slowCounter = new AtomicInteger(0);
    private AtomicInteger runtimeExceptionCounter = new AtomicInteger(0);
    private AtomicInteger hossaExceptionCounter = new AtomicInteger(0);
    private AtomicInteger bertaExceptionCounter = new AtomicInteger(0);

    @RequestMapping("/hello")
    public String hello() {
        LocalDateTime.now();
        String msg = LocalDateTime.now()
                + ", Demotime, Hello App running on host "
                + System.getenv("HOSTNAME");

        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/stats")
    public String stats() {
        LocalDateTime.now();
        String msg = LocalDateTime.now()
                + ", fastCounter=" + fastCounter.get()
                + ", mediumCounter=" + mediumCounter.get()
                + ", slowCounter=" + slowCounter.get()
                + ", runtimeExceptionCounter=" + runtimeExceptionCounter.get()
                + ", hossaExceptionCounter=" + hossaExceptionCounter.get()
                + ", bertaExceptionCounter=" + bertaExceptionCounter.get();

        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/hello/properties")
    public String properties() {
        StringWriter writer = new StringWriter();
        System.getProperties().list(new PrintWriter(writer));
        return writer.getBuffer().toString();
    }

    @RequestMapping("/hello/wd")
    public String wd() {

        String workingDirectory = System.getProperty("user.dir");

        return "working directorym is '" + workingDirectory + "'" +
                ";" +
                dir(workingDirectory) +
                ";" +
                dir("data");
    }

    @RequestMapping("/hello/fast")
    public String fast() {
        randomPause(MILLIS, 30);
        return "Greetings from Spring Boot, fastCounter=" + fastCounter.incrementAndGet();
    }

    @RequestMapping("/hello/fast-berta")
    public String fastBerta() {
        randomPause(MILLIS, 30);
        try {
          throwBertaException();
        } catch(BertaException ihe) {
          // nop
        }
        return "Greetings from Spring Boot, bertaExceptionCounter=" + bertaExceptionCounter.get();
    }

    @RequestMapping("/hello/medium")
    public String medium() {
        randomPause(SECONDS, 5);
        return "Greetings from Spring Boot, mediumCounter=" + mediumCounter.incrementAndGet();
    }

    @RequestMapping("/hello/slow")
    public String slow() {
        randomPause(SECONDS, 10);
        return "Greetings from Spring Boot, slowCounter=" + slowCounter.incrementAndGet();
    }

    @RequestMapping("/hello/exception/runtime")
    public String exceptionRuntime() {
        throw new RuntimeException("" + runtimeExceptionCounter.incrementAndGet());
    }

    @RequestMapping("/hello/exception/hossa")
    public String exceptionHossa() {
        throw new HossaException("" + hossaExceptionCounter.incrementAndGet());
    }

    private static void randomPause(int factor, int maxWait) {
        try {
            Thread.sleep(factor * new Random().nextInt(maxWait));
        } catch (InterruptedException e) {
            //
        }
    }

    private void throwBertaException() {
        throw new BertaException("" + bertaExceptionCounter.incrementAndGet());
    }

    private static String dir(String dirName) {
        StringBuilder sb = new StringBuilder();
        sb.append("file count in directory '").append(dirName).append("'").append(" is ");
        try {
            sb.append(Files.list(Paths.get(dirName)).count());
        } catch (IOException e) {
            sb.append("failed to access directory, reason was ").append(e);
        }
        return sb.toString();
    }

}
