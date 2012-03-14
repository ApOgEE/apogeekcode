/*
 * sso-parser.c
 * 
 * Copyright 2012 M. Fauzilkamil Zainuddin <fauzil@persiasys.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <libxml/xmlmemory.h>
#include <libxml/parser.h>

//typedef struct myssoLogin ssoLogin;

struct myssoLogin{
	char *user;
	char *pass;
	char *realm;
	char *proxy;
	char *ident;
};

typedef struct myssoLogin ssoLogin;


ssoLogin * parseDoc(char *docname) 
{
	xmlDocPtr doc;
	xmlNodePtr cur;
	xmlChar *key;
	xmlChar *val;

	doc = xmlParseFile(docname);
	
	if (doc == NULL ) {
		fprintf(stderr,"Document not parsed successfully. \n");
		return;
	}
	
	cur = xmlDocGetRootElement(doc);
	
	if (cur == NULL) {
		fprintf(stderr,"empty document\n");
		xmlFreeDoc(doc);
		return;
	}
	
	if (xmlStrcmp(cur->name, (const xmlChar *) "sso")) {
		fprintf(stderr,"document of the wrong type, root node != sso");
		xmlFreeDoc(doc);
		return;
	}
	
	cur = cur->xmlChildrenNode;
	
	char *proxy;
	char *identity;
	char *username;
	char *password;
	char *realm;
	int u_ok = 0;
	int p_ok = 0;

	ssoLogin *sso = malloc(sizeof(sso)*1024);

	while (cur != NULL) {
		if ((!xmlStrcmp(cur->name, (const xmlChar *)"d"))){
		    key = xmlGetProp(cur, "k");
		    if (!xmlStrcmp(key, (const xmlChar *)"sip.auth.userid")) {
				sso->user = malloc(125);
				sso->user = xmlGetProp(cur, "v");
				u_ok = 1;
			}
		    if (!xmlStrcmp(key, (const xmlChar *)"sip.auth.password")) {
				sso->pass = malloc(125);
				sso->pass = xmlGetProp(cur, "v");
			}
		    if (!xmlStrcmp(key, (const xmlChar *)"sip.auth.realm")) {
				sso->realm = malloc(125);
				sso->realm = xmlGetProp(cur, "v");
			}
		    if (!xmlStrcmp(key, (const xmlChar *)"sip.address.server.host")) {
				sso->proxy = malloc(125);
				sso->proxy = xmlGetProp(cur, "v");
				p_ok = 1;
			}
		}
		 
		cur = cur->next;
	}
	
	if (u_ok && p_ok) {
		sso->ident = malloc(125);
		sprintf(sso->ident,"sip:%s@%s",sso->user, sso->pass);
	}
	
	xmlFreeDoc(doc);
	return sso;
}

int main(int argc, char **argv) 
{
	char *docname;
	ssoLogin * sso;
		
	if (argc <= 1) {
		printf("Usage: %s sso_xml.xml\n", argv[0]);
		return(0);
	}

	docname = argv[1];
	sso = parseDoc(docname);
	
	printf("SSO Details\n");
	printf("username: %s\n",sso->user);
	printf("password: %s\n",sso->pass);
	printf("realm: %s\n",sso->realm);
	printf("proxy: %s\n",sso->proxy);
	printf("ident: %s\n",sso->ident);

	return (1);
}
