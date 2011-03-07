# a2bconf2db - A2Billing Conf file to Database
## What's up?

    Author: M. Fauzilkamil Zainuddin <apogee@apogeek.com>
    Title: a2bconf2db PHP script
    Copyright (C) 2011, M. Fauzilkamil Zainuddin

**a2bconf2db** is a PHP CLI Script to copy agi config from a2billing.conf (v1.3.3) to database (v1.7.1)

I found that on a2billing 1.3.3, the agi-conf is in /etc/asterisk/a2billing.conf. However, since a2billing 1.6.0
which I tried to migrate, the agi-conf is in database. So, I made this script to copy the agi-conf (I have up to agi-conf10) 
from a2billing.conf to a2billing 1.7.1 database. Here is how to use the script.

1. Copy your /etc/asterisk/a2billing.conf from a2b 1.3.3 to 'data' directory.

2. Edit lib/dbconf.inc to match your database settings 

3. Run the script from command line:
    $ php proconf.php

4. Check your agi-conf is updated in your a2billing admin

This code is provided as is. I have no warranty that all my code will be functioning as good as it is running
in my system. I will not be responsible of any damage/loss caused by this script. If you have no idea on 
what this code is doing, it is safe to not to use it at all.

If you want to know more about me, visit: [http://coderstalk.blogspot.com](http://coderstalk.blogspot.com)
