#Socket
require "socket"

s0 = TCPServer.open(10000)

while true  
    sock = s0.accept
    while buf = sock.gets
        print buf
        $URL = buf
        system 'open '+$URL
    end
    sock.close
end
