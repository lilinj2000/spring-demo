#nohup /usr/java/jdk1.8.0_181-cloudera/bin/java -jar -Djava.security.krb5.debug=true -Djava.security.krb5.conf="/etc/krb5.conf" -Djavax.security.auth.useSubjectCredsOnly=false -Dspring.profiles.active=test demo-hive-0.0.1-SNAPSHOT.jar >demo-hive.log 2>&1 &

# ok
#nohup /usr/java/jdk1.8.0_181-cloudera/bin/java -Djavax.security.auth.useSubjectCredsOnly=false  -jar demo-hive-0.0.1-SNAPSHOT.jar --spring.profiles.active=test > log/demo-hive.log 2>&1 &