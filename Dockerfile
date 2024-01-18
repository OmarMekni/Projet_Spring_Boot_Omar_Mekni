FROM tomcat:latest
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/test-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/Projet_Spring_Boot_Omar_Mekni-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["catalina.sh", "run"]