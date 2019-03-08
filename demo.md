# Demo OpenShift Deployment

Wir haben eine kleine Hello Applikation in einem Github Projekt:

https://github.com/marvinO1/hello-app

Dieses habe ich auf zwei Arten in einer OpenShift Online Instanz auf zwei Arten deployed

#### Als Docker Image
* http://hello-route-marvino1-example.1d35.starter-us-east-1.openshiftapps.com/hello

Wir bauen die Applikation lokal wie folgt
* Jar bauen
* Docker Image bauen
* Docker Image auf Docker Hub laden
* OpenShift informieren dass das Image geändert hat


#### Als Source2Docker Image
* http://hello2-app-marvino1-example.1d35.starter-us-east-1.openshiftapps.com/hello

Wir bauen die Applikation direkt in OpenShift

* Changes in Github pushen
* Github informiert OpenShift
* Dieses lädt sich die Sourcen runter und baut die Applikation bei sich


## Wer ist nun schneller

Client auf die lokal gebaute App
```
  for($i = 0; $i -lt 999999999; $i++)
  {
    Invoke-RestMethod http://hello-route-marvino1-example.1d35.starter-us-east-1.openshiftapps.com/hello
    Start-Sleep -Seconds 1
  }
```

Client auf die in OpenShift gebaute App
```
  for($i = 0; $i -lt 999999999; $i++)
  {
    Invoke-RestMethod http://hello2-app-marvino1-example.1d35.starter-us-east-1.openshiftapps.com/hello
    Start-Sleep -Seconds 1
  }
```

## Lokaler Build in einer DOS Box gestartet :-)




