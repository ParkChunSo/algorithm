// 와일드카드 문제
// p.218

#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool match(const string& w, const string& s);

int main()
{
	int count;
	printf("테스트 케이스의 횟수를 입력하세요.\n");
	scanf_s("%d", &count);

	for (int i = 0; i < count; i++) {
		string w;
		int n;
		cin >> w;
		scanf_s("%d", &n);
		vector<string> files;
		for (int j = 0; j < n; j++) {
			string tmp;
			cin >> tmp;
			files.push_back(tmp);
		}

		for (int j = 0; j < files.size(); j++) {
			if (match(w, files[j]))
				cout << files[j] << endl;
		}
	}
	return 0;
}

bool match(const string& w, const string& s) {
	int p = 0;
	while (w.size() > p && s.size() > p && (w[p] == '?' || w[p] == s[p]))
		++p;

	if (s.size() == p)
		return w.size() == p;

	if (w[p] == '*') {
		for (int skip = 0; skip + p <= s.size(); skip++) {
			if (match(w.substr(p + 1), s.substr(p + skip)))
				return true;
		}
	}
	return false;
}