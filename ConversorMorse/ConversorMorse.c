#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

char morse[27][5] = {
	".-",
	"-...",
	"-.-.",
	"-..",
	".",
	"..-.",
	"--.",
	"....",
	"..",
	".---",
	"-.-",
	".-..",
	"--",
	"-.",
	"---",
	".--.",
	"--.-",
	".-.",
	"...",
	"-",
	"..-",
	"...-",
	".--",
	"-..-",
	"-.--",
	"--..",
	" "
};

char binario[27][10] = {
	"0000 ",
	"0001 ",
	"0010 ",
	"0011 ",
	"0100 ",
	"0101 ",
	"0110 ",
	"0111 ",
	"1000 ",
	"1001 ",
	"1010 ",
	"1011 ",
	"1100 ",
	"1101 ",
	"1111 ",
	"00010000 ",
	"00010001 ",
	"00010010 ",
	"00010011 ",
	"00010100 ",
	"00010101 ",
	"00010110 ",
	"00010111 ",
	"00011000 ",
	"00011001 ",
	"00011010 ",
	"00011011 "
};

void converterMorse(char input[]) {
	char temp[2],ch[6] = "",frase[1000] = "";
	int i,j;

	temp[0] = input[0];
	temp[1] = 0;

	strcat(ch, temp);

	for (i = 1; i < strlen(input) + 1; i++) {
		if ((input[i] == ' ') || (i == (strlen(input)))) {
			for (j = 0; j < sizeof(morse); j++) {
				if (strcmp(ch, morse[j]) == 0) {
					strcpy(ch, binario[j]);    
					break;
				}
			}

			strcat(frase, ch);

			if ((i != strlen(input))) {
				strcat(frase, binario[26]);
			}

			strcpy(ch, "");
		} else {
			temp[0] = input[i];
			temp[1] = 0;
			strcat(ch, temp);
		}
	}

	printf("\nResultado da tradução: %s\n", frase);
}

int main() {
	setlocale(LC_ALL, "Portuguese");

	char letrasmorse[200];

	printf("=== Digite letras em código morse para serem convertidas para bináro (colocar espaços entre cada uma).\n\nEntrada: ");
	scanf("%[^\n]s", letrasmorse);
	fflush(stdin);

	converterMorse(letrasmorse);
	
	return 0;
}
