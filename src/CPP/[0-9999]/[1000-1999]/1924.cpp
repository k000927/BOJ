#include <iostream>
using namespace std;

int main(){
	int month, day;
	cin >> month >> day;
	if(month == 1);
	else if(month == 2) day += 31;
	else if(month == 3) day += 59;
	else if(month == 4) day += 90;
	else if(month == 5) day += 120;
	else if(month == 6) day += 151;
	else if(month == 7) day += 181;
	else if(month == 8) day += 212;
	else if(month == 9) day += 243;
	else if(month == 10) day += 273;
	else if(month == 11) day += 304;
	else day += 334;
	
	if(day%7 == 0) cout << "SUN" << endl;
	else if(day%7 == 1) cout << "MON" << endl;
	else if(day%7 == 2) cout << "TUE" << endl;
	else if(day%7 == 3) cout << "WED" << endl;
	else if(day%7 == 4) cout << "THU" << endl;
	else if(day%7 == 5) cout << "FRI" << endl;
	else cout << "SAT" << endl;
}