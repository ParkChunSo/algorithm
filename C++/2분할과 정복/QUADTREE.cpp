// QUADTREE 뒤집기
// p.189

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

string reverse(string::iterator& it);

int main()
{
	int count;
	printf("테스트 케이스의 횟수를 입력하세요.\n");
	scanf_s("%d", &count);

	for (int i = 0; i < count; i++) {
		string str;
		cin >> str;
		string::iterator it = str.begin();
		string result = reverse(it);
		cout << result << endl;
	}
	return 0;
}

string reverse(string::iterator& it) {
	char head = *it;
	++it;
	if (head == 'b' || head == 'w')
		return string(1, head);
	string leftTop = reverse(it);
	string rightTop = reverse(it);
	string leftBottom = reverse(it);
	string rightBottom = reverse(it);

	return string("x") + leftBottom + rightBottom + leftTop + rightTop;
}
