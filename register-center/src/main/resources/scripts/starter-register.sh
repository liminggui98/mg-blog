echo "starting register-center1"
nohup java -jar -Dspring.profiles.active=server1 register-center-1.0-SNAPSHOT.jar >server1.log 2>&1 &
echo "started register-center2"
echo "starting register-center2"
nohup java -jar -Dspring.profiles.active=server2 register-center-1.0-SNAPSHOT.jar >server2.log 2>&1 &
echo "started register-center2"
echo "starting register-center3"
nohup java -jar -Dspring.profiles.active=server3 register-center-1.0-SNAPSHOT.jar >server3.log 2>&1 &
echo "started register-center3"
echo "enter any character to exit"
read
ps -ef | grep register
