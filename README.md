thrinatra
=========

Simple Scala Webserver Template with Thrift and Mongo via Finatra and Spindle and Heroku and Bootstrap

Getting Started
---------------

    export THRINATRA_APP="thrinatra"  # Put the name of your app here
    git clone https://github.com/paperstreet/thrinatra.git --origin thrinatra $THRINATRA_APP
    cd $THRINATRA_APP
    heroku apps:create --addons=mongohq $THRINATRA_APP
    heroku config:set SBT_CLEAN=true
    git push heroku master
    open "http://$THRINATRA_APP.herokuapp.com"


TODO
----
