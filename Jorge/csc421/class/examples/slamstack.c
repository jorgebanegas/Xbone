#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

#define SLAM "smash"

/*
 * slamstack
 * author: burt rosenberg
 * created: 1 october 2017
 * copyright (2017) burt rosenberg
 */

/*
	This program demonstrates stack smashing. For the classic 
	account, see Aleph Zero's "Stack Smashing for Fun and Profit".

	The main calls function f, and function f calls function g. 

	Function f defines a local variable buf, which uses memory in
	f's stack frame, copies a string into that buffer. 
	It prints the contents of that buffer before and after the call to g.

	Since f keeps the pointer to buf private (i.e. it does not pass the
	pointer to g), it is normally expected that buf will be unchanged
	by the running of g, but it is change (i.e. it is made uppercase) .

	g does not have a pointer to buf, so it "steals" one.

	Because f's stack frame is above g's, if g were to get a pointer
	to anythign it it's stack frame, it can increment that pointer looking
	for buf, unconstrained by the normal workings of stack frames.
	In this example, g knows when it has found buf by inspecting memory
	contents and comparing to the known contents of buf.

	This is just an example of how a program can reach up in a stack 
	and change the contents of variables. Other applications can use
	different mechanisms for triangulating items on the stack, and 
	manipulate those items for much more nefarious purposes.

 */

char *  g() {
	char marker  ;
	char * cp ;
	int finding ;
	char * fp ;

	// find SLAM on the stack
	cp = &marker ;
	printf("line %d: starting search at %p\n",__LINE__, cp ) ;
	finding = 0 ;
	while (cp++) {
		if ( *cp == SLAM[finding] ) {
			if ( !finding ) fp = cp ;
			finding++ ;
			if ( !SLAM[finding] ) {
				//found 	
				//return fp ;
				break ;
			}
		}
		else {
			fp = cp ;
		}
	}

	// SLAM starts a fp on the stack
	cp = fp ;
	while (*fp) {
		*fp = toupper(*fp) ;
		fp++ ;
	}
	return cp ;
}

int f() {
	char buf[100] ;
	char * cp  ;
	strcpy(buf, SLAM) ;

	printf("line %d: buf= %s\n", __LINE__, buf) ;
	if (( cp = g() )) 
		printf("line %d: string |" SLAM "| found on stack at %p\n", 
		__LINE__, cp ) ; 
	printf("line %d: buf= %s\n", __LINE__, buf) ;

	return 0 ; 
}

int main(int argc, char * argv[]) {
	f();
	return 0 ;
}

