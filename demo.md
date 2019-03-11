# Demo OpenShift Deployment

Ich habe diese App auf zwei Arten in einer OpenShift Online Instanz deployed
* https://manage.openshift.com/ 

#### Als Docker Image aus meinen Docker Hub
* http://hello-app-marvino1-example.1d35.starter-us-east-1.openshiftapps.com/hello

Wir bauen die Applikation lokal wie folgt
* Jar bauen
* Docker Image bauen
* Docker Image auf Docker Hub laden
* OpenShift informieren dass das Image geändert hat


#### Als Source2Docker Image aus meinen Git Hub
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
    Invoke-RestMethod http://hello-app-marvino1-example.1d35.starter-us-east-1.openshiftapps.com/hello
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
```
Terminal öffnen 
build 
```

## Erkenntisse
* lokal bauen und erst dann in Openshift laden war jedes mal schneller (ok, eventuell ist meine Gratis Demo Instanz von Openshift zu klein :-))
* Grundsätzlich ist die Source2Docker aber recht einfach - jeder commit auf dem GIT führt zu einem Deployment. 




