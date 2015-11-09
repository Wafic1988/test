
# Get process pid from pid file
processPid=$(head -n 1 pid)

# If pid exists kill the process and empty pid file, otherwise the process is not running
if [ -n "$processPid" ]; then
	kill $processPid
	echo "Stopping Http server ("$processPid")"
	> pid
else
	echo "Http server is not running"
fi

