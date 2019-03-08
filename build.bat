call mvn clean install
call docker image build -f Dockerfile -t marvino1/hello-app .
call docker login
call docker push marvino1/hello-app:latest
call oc.exe login https://api.starter-us-east-1.openshift.com --token=LdEwsx2YiQVkq7sqdLnXfcMSI3-Y23vVuLhUgkBqV0k
call oc.exe import-image hello-app --from=marvino1/hello-app:latest --confirm

  
