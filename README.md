# truststore-test
A simple Java program to test truststore file.

The aim is to test how the Java truststore work with expired certificates.

## Usage

    java src/Main.java [url] <truststore-file> <password> 
    
Example:

    java src/Main.java https://nyt.com truststore.jks changeit
    
    # Will use the defualt password changeit
    java src/Main.java https://nyt.com nyt.jks

    # Not using a local, but your system truststore 
    java src/Main.java https://nyt.com


## How to generate a Java Key Store (JKS) file
   
You may need to install keytool, that is part of the java tool box.

    $ sudo apt install openjdk-11-jre-headless   

## JKS file
Add a certificate to a key store file:

    $ keytool -import -alias nyt -keystore nyt.jks -file nyt.cer

View contents of a jks file:

    $ keytool -v -list -keystore nyt.jks

    
