#!/bin/bash

# DEPENDENCIES ( RUN this to fix dependencies related issues)
# sudo apt install pandoc texlive-latex-full

outputDocDir="docs/"
outputTextDir="texts/"

# commented because it doesn't support devnagri
# fontFamily="Times New Roman"
fontSize="12pt"
fontFamily="Lohit Devnagari"


# correct usage
if [ -z "$1" ] || [ -z "$2" ]
    then

        echo -e "Usage $0 [convertTo] [file]\n specify either t or d in convertTo argument t->text, d-> docx \nfile is the file you want to convert"
        exit

fi

convertTo="$1"
fileToConvert="$2"


case "${convertTo}" in
    "d")
        echo "converting $fileToConvert to docx..."

        if [[ $(echo "$fileToConvert" | cut -d . -f 2) != "txt" ]];
        then
                echo "specify a text file to convert to docx"
                exit
        fi

        outputFile="${outputDocDir}$(echo "$fileToConvert" | cut -d '.' -f 1).docx"

        mkdir -p "$outputDocDir"

        pandoc "$fileToConvert" --pdf-engine=xelatex\
        -V "fontfamily:$fontFamily"\
        -V "mainfont:$fontFamily"\
        -V "fontsize:$fontSize"\
        -o "$outputFile"

        echo "Saved to $outputDocDir"

    ;;

    "t")


        if [[ $(echo "$fileToConvert" | cut -d . -f 2) != "docx" ]];
        then
                echo "specify a doc file to convert to text"
                exit
        fi


        mkdir -p "$outputTextDir"


        echo "converting $fileToConvert to text"

        outputFile="${outputTextDir}$(echo "$fileToConvert" | cut -d '.' -f 1).txt"

        
        pandoc "$fileToConvert" -o "$outputFile"

        echo "Saved to $outputTextDir"


    ;;
    *)
        echo "Select a valid option for convertTo Argument"
        exit
    ;;
esac
