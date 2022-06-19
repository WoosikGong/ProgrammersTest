#include <string>
#include <vector>
 
using namespace std;
 
int solution(vector<string> lines) {
    int answer = 0;
    int* start = new int[lines.size()]{ 0, };
    int* end = new int[lines.size()]{ 0, };
    int count = 0;
 
    for (int i = 0; i < lines.size(); i++)
    {
        end[i] = (atoi(lines[i].substr(11, 2).c_str()) * 3600000 + atoi(lines[i].substr(14, 2).c_str()) * 60000 + atoi(lines[i].substr(17, 2).c_str()) * 1000 + atoi(lines[i].substr(20, 3).c_str()));
 
        start[i] = (atoi(lines[i].substr(11, 2).c_str()) * 3600000 + atoi(lines[i].substr(14, 2).c_str()) * 60000 + atoi(lines[i].substr(17, 2).c_str()) * 1000 + atoi(lines[i].substr(20, 3).c_str()) - (atof(lines[i].substr(24, 5).c_str()) * 1000) + 1);
 
    }
 
    for (int i = 0; i < lines.size(); i++)
    {
        count = 0;
        for (int j = i; j < lines.size(); j++)
        {
            if (end[i] + 1000 > start[j])
            {
                count++;
            }
        }
        if (count > answer)
            answer = count;
    }
    return answer;
}