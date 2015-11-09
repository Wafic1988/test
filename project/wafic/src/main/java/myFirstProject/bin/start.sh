
# Get process pid from pid file
processPid=$(head -n 1 pid)

# If pid exists process is already running, if not start the process and put the pid in the pid file
if [ -n "$processPid" ]; then
	echo "Http server already running ("$processPid")"
else
	java -cp /git/master/project/wafic/target/wafic-1.0-SNAPSHOT.jar:/git/lib/* myFirstProject.App &
	echo "Http server starting . . . ("$!")"
	echo $! > pid
fi

