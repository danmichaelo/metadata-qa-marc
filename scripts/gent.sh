#!/usr/bin/env bash

. ./setdir.sh
NAME=gent
TYPE_PARAMS="--marcVersion GENT"
MARC_DIR=${BASE_INPUT_DIR}/gent/marc
MASK=*.mrc

. ./common-script

echo "DONE"
exit 0