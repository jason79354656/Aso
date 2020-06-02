#!/bin/bash
actualDate=""

function getDate(){
	date > date.txt
	while read -r line; do
		actualDate='#'$line
	done < date.txt
	rm date.txt
}

function moveFile(){
	touch tmp.txt
	sed '2,$d' $1 > tmp.txt #tmp contiene el archivo con la primera  linea
	sed -i '1d' $1 #elimina la primera linea
	while read -r line; do
		echo "#"$line >> tmp.txt
	done < $2
	echo $actualDate >> tmp.txt
	cat $1 >> tmp.txt
	cat tmp.txt > $1
	rm tmp.txt
}
#$1 sera el file .sh
#$2 sera el file copyright
getDate
moveFile $1 $2
