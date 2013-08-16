#!/bin/bash
echo "svnadmin create ~/svn/repository/$1"
svnadmin create ~/svn/repository/$1

echo "cp -f conf/svnserve.conf ~/svn/repository/$1/conf/"
cp -f ~/svn/conf/svnserve.conf ~/svn/repository/$1/conf/

echo "svn mkdir svn://localhost/$1/trunk svn://localhost/$1/branches svn://localhost/$1/tags -m 'init structure'"
svn mkdir svn://localhost/$1/trunk svn://localhost/$1/branches svn://localhost/$1/tags -m "init structure" --username tim --password 753951

