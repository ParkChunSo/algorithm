// 보글 게임
// p.150

#include "stdafx.h"
#include <vector>
#include <iostream>
#include <string>

using namespace std;

bool hasWord(int x, int y, const string &word);
bool inRange(int x, int y);

static char boggle[5][5] = {
	{'U','R','L','P','M'},
	{'X','P','R','E','T'},
	{'G','I','A','E','T'},
	{'X','T','N','Z','Y'},
	{'X','O','Q','R','S'} 
};

const int dx[8] = { -1, 0, 1, 1, 1, 0, -1, -1 };
const int dy[8] = { -1, -1, -1, 0, 1, 1, 1, 0 };

int main()
{
	int count;
	printf("테스트 케이스의 횟수를 입력하세요.\n");
	scanf_s("%d", &count);

	for (int i = 0; i < count; i++) {
		string word;
		int x, y;
		printf("\n찾은 단어를 입력하세요.\n");
		cin >> word;	// scanf("%[^\n]\n", s); // 줄 바꿈 문자를 제거한 문자만 입력받음
		printf("\n찾은 단어의 첫 문자 x, y 를 입력하세요.\n");
		scanf_s("%d %d", &x, &y);

		if (hasWord(x, y, word))
			printf("있습니다.\n");
		else
			printf("없습니다.\n");
	}
    return 0;
}

bool hasWord(int x, int y, const string &word) {
	//기저사례
	if (!inRange(x, y))
		return false;
	if (boggle[y][x] != word[0])
		return false;
	if (word.size() == 1)
		return true;

	for (int i = 0; i < 8; i++) {
		int nextX = x + dx[i], nextY = y + dy[i];
		if (hasWord(nextX, nextY, word.substr(1))) {
			return true;
		}
	}
	return false;
}

bool inRange(int x, int y) {
	if (x < 5 && x > -1 && y < 5 && y > -1) {
		return true;
	}
	return false;
}
