#include <assert.h>
#include <string.h>

int length(char* str) {
	int n = 0;

	// Current location and character
	char* p = str;
	while (*p) { // until null-terminator reached
		n++;
		p++;
	}

	return n;
}

// Swap characters at pointers
void swap(char* a, char* b) {
	char tmp = *a;
	*a = *b;
	*b = tmp;
}

// Sway characters at index in string
void swapChars(char* str, int i, int j) {
	swap(str + i, str + j);
}

// Reverse string of length n
void reverse(char* str, int n) {
	int i;
	for (i = 0; i < n / 2; i++) {
		swapChars(str, i, n - 1 - i);
	}
}

// Q1.2
// Reverse null-terminated string
void reverse(char* str) {
	reverse(str, length(str));
}

// Tests
int main() {
    const int max = 15;
    const int cases = 5;

    char in[cases][max];
    char out[cases][max];
    char len[cases];

    strcpy(in[0], "abc");
    strcpy(out[0], "cba");
    len[0] = 3;

    strcpy(in[1], "");
    strcpy(out[1], "");
    len[1] = 0;

    strcpy(in[2], "a");
    strcpy(out[2], "a");
    len[2] = 1;

    strcpy(in[3], "racecar");
    strcpy(out[3], "racecar");
    len[3] = 7;

    strcpy(in[4], "even");
    strcpy(out[4], "neve");
    len[4] = 4;

    int i;
    for (i = 0; i < cases; i ++) {
        reverse(in[i]);
        assert(strncmp(in[i], out[i], len[i]) == 0);
    }

    return 0;
}