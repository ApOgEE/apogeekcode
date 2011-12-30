/*
 * socket_client.c  Copyright (C) 2011, M. Fauzilkamil Zainuddin
 *
 * Author: M. Fauzilkamil Zainuddin	<jerungkun@gmail.com>
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h> 

#define HOST "coderstalk.blogspot.com"

void error(const char *msg)
{
    perror(msg);
    exit(0);
}

/*
 * gen_httpreq - generate http request
 *
 * return (char *) http reuest string
 */
char *gen_httpreq() 
{
    char *reqstring;
    char *tmpl = "GET / HTTP/1.0\r\nHost: %s\r\nUser-Agent: APOWebclient 0.1\r\n\r\n";

    reqstring = malloc(strlen(tmpl)+strlen(HOST));
    sprintf(reqstring, tmpl, HOST);
    //strcpy(reqstring, tmpl);
    return (char *)reqstring;
}

int main(int argc, char *argv[])
{
    int sockfd, portno, n;
    struct sockaddr_in serv_addr;
    struct hostent *server;
    
    char *httpreq;


    char buffer[256];
    /*if (argc < 3) {
       fprintf(stderr,"usage %s hostname port\n", argv[0]);
       exit(0);
    }*/
    //portno = atoi(argv[2]);
    portno = 80;
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) 
        error("ERROR opening socket");
    server = gethostbyname(HOST);
    if (server == NULL) {
        fprintf(stderr,"ERROR, no such host\n");
        exit(0);
    }
    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char *)server->h_addr, 
         (char *)&serv_addr.sin_addr.s_addr,
         server->h_length);
    serv_addr.sin_port = htons(portno);
    if (connect(sockfd,(struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
        error("ERROR connecting");
    //printf("Please enter the message: ");
    //bzero(buffer,256);
    //fgets(buffer,255,stdin);
    //n = write(sockfd,buffer,strlen(buffer));
    //if (n < 0) 
    //    error("ERROR writing to socket");
    httpreq = gen_httpreq();
    n = write(sockfd,httpreq,strlen(httpreq));
    free(httpreq);

    if (n < 0) 
        error("ERROR writing to socket");

    int i;
    int stopflag = 0;
    //for (i=0;i<20;i++) 
    while (stopflag == 0)
    {
        bzero(buffer,256);
        n = read(sockfd,buffer,255);
        if (n < 0) 
             error("ERROR reading from socket");
        printf("%s",buffer);
        if (strlen(buffer) == 0) {
            printf("\n");
            stopflag = 1;
        }
        //printf("\n=== strlen %d ===\n", strlen(buffer));
    }

    close(sockfd);
    return 0;
}

