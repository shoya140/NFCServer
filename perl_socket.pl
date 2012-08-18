use strict;
use warnings;
use AnyEvent;
use AnyEvent::Socket;

tcp_server undef, 10000, sub {
    my ($fh) = @_;
    while (my $line = <$fh>) {
        chomp $line;
        print $line, "\n";
        system open => $line;
    }
};

AE::cv->recv;