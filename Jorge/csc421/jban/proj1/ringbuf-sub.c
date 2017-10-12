#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<assert.h>

#include "ringbuf.h"

/*
 * author: Jorge Banegas
 * date: 09/29/17
 * pledge: this is my own work, unless otherwise noted
 *
 */


/* static variables (zeroed) */

int g_debug = 0 ;
int is_verbose = 0 ;
int array_size = 0;

struct RingBuf rb ;


int rb_ioctl(int op) {
	switch (op) {
	case RB_Q_SIZE:
		return RINGBUF_SIZE ;
	case RB_IS_EMPTY:
	{
		if (rb.tail == rb.head)
		{	
			if(rb.is_full == 1)
				return 0;

			return 1;
		}
		else
			return 0;
	}
	case RB_IS_FULL:
	{
		if (rb.is_full == 1)
			return 1;
		else
			return 0;
	}	
	case RB_Q_COUNT:
	{
		int counter = 0;
		
		for(int i=0;i<RINGBUF_SIZE;i++)
		{
			if(rb.ringbuf[i] != 0)
			counter++;
		}
		return counter;
	}
	default: 
	return 0;
}
	}

int rb_enqueue(int ele) {
	if(rb_ioctl(2) == 1)
		return -1;

	if(rb_ioctl(2) == 0)
	{
		rb.ringbuf[rb.head] = ele;
		rb.head = (rb.head+1) % RINGBUF_SIZE;
		if(rb.head == rb.tail)
			rb.is_full = 1;
	}
}

int rb_dequeue(void) {
	int temp = 0;

	if(rb_ioctl(1) == 0)
	{	temp = rb.ringbuf[rb.tail];
		rb.ringbuf[rb.tail] = 0;
		rb.tail = (rb.tail+1) % RINGBUF_SIZE;
		rb.is_full = 0;
		return temp;
	}
	if(rb_ioctl(1) == 1)
		return -1;
}

