FROM jetty:9
RUN java -jar "$JETTY_HOME/start.jar" --add-to-start=cdi --approve-all-licenses
COPY ./target/*.war /var/lib/jetty/webapps/ROOT.war
