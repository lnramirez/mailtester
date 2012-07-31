mailtester
==========

mailtester is a fake SMTP server that leverages [SubEtha SMTP](http://code.google.com/p/subethasmtp/). Allows you to test email functionality in an easy way

***

How do I use it?
----------------

1. mailtester listens to port 2500 for stmp calls.
2. whatever you send will be display on `http://localhost:8283/mailtester/`


***

How do I build it?
-------------------------

1. `$ git clone git://github.com/lnramirez/mailtester.git`
2. `$ cd mailtester`
3. `$ gradle install`
4. `$ gradle jettyRun`

