// JadenCase 문자열 바꾸기
// 프로그래머스 Level2

#include "stdafx.h"
#include <iostream>
#include <vector>

using namespace std;

string solution(string s) {
	string answer = "";
	bool isFirst = true;
	for (char c : s) {
		if (c == ' ')
			isFirst = true;
		else {
			if (isalpha(c) > 0) {
				if (isFirst)
					c = toupper(c);
				else
					c = tolower(c);
			}
			isFirst = false;
		}
		answer += c;
	}
	return answer;
}