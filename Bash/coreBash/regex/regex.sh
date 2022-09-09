#!/bin/sh

#Strings containing a, b, c
grep -i "[abc]" names.txt

#Strings containing an s followed by e
#Harry James Potter, Lily Potter, James Potter
grep -i "[s]e" names.txt

#names with an ae, be, ce
#Dumbeldore
grep -i "[a-c]e" names.txt

#name should begin with s
grep -i "^s" names.txt

#combining commands with pipe
#find file name starting with r
ls | grep "^r"