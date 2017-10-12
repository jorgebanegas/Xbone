#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

#define SLAM "smash"

/*
 * slamquiz
 * author: Jorge Banegas
 * created: 1 october 2017
 */


char *  g(int * i) {
	// set the value of the address above i which is j, to 2.
	*(i + 1) = 2;

	return 0;
}

int f() {
	int i ;
	int j ;
	i = j = 1 ;
	printf("line %d: i=%d, j= %d\n", __LINE__, i, j) ;
	g(&i) ;
	printf("line %d: i=%d, j= %d\n", __LINE__, i, j) ;

	return 0 ; 
}

int main(int argc, char * argv[]) {
	f();
	return 0 ;
}

