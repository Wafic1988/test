
# Get process pid from pid file
processPid=$(head -n 1 pid)

# If pid exists process is running, otherwise it's not
if [ -n "$processPid" ]; then
	echo "Http server is running ("$processPid")"
else
	echo "Http server is not running"
fi

