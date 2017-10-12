#
# a very generic makefile, to make what's in this directory
# author: bjr
# created: 1 oct 2017
# last update:
#

slam_quiz: slam_quiz.c
	cc -o $@ $<
	
test: slam_quiz
	./slam_quiz > slam_quiz.out
	diff slam_quiz.out slam_quiz.ref
	
clean:
	-rm slam_quiz slam_quiz.out
	
