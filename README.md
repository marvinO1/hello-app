# hello-app
Spring-Boot Actuator Example with 
* enabled [prometheus metrics](https://prometheus.io/)
* REST API for doing simple tests on OpenShift or any other runtime 

# Java
```
java -jar hello-app-0.1.0.jar --management.endpoints.web.exposure.include=*
```

# Docker 
```
docker image build -f Dockerfile -t marvino1/hello-app .
docker login ...
docker 
docker container run -d --name spring-8080 -p 8080:8080 marvino1/hello-app
docker container run -d --name spring-8081 -p 8081:8080 marvino1/hello-app
```

# Spring native actuator endpoints
```
http://localhost:8080/actuator
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/metrics/{name-of-metrics}
```
# Prometheus actuator endpoints
```
http://localhost:8080/actuator/prometheus
```

# Business endpoints :-)
```
http://localhost:8080/hello
  Show simple statistics
  
http://localhost:8080/hello/properties
  Show properties of jvm
  
http://localhost:8080/hello/wd
  Show some simple information about the current working directory
    
http://localhost:8080/hello/fast  
  Returns within a couple of milliseconds  

http://localhost:8080/hello/fast-berta
  Returns within a couple of milliseconds but throws and catches BertaException 
  
http://localhost:8080/hello/medium
  Returns within 5 seconds

http://localhost:8080/hello/slow
  Returns within 10 seconds
  
http://localhost:8080/hello/exception/runtime
  Throws a RuntimeException

http://localhost:8080/hello/exception/hossa
  Throws a HossaException
    
```


# Create load
## Unix
In bash shell execute
```
while [ true ] ; do time curl <endpoint-url> ; sleep 1 ; done
```
You can remove the sleep from this command to increase the load.

## Windows10
In Powershell execute 
```
for($i = 0; $i -lt 999999999; $i++)
{
  Invoke-RestMethod <endpoint-url>
  Start-Sleep -Seconds 1
}
```
You can remove the sleep from this command to increase the load.
