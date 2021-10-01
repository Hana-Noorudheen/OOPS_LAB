/*
1.Define a class Date. Overload the operator '+' such that it adds a given date with certain number of days.
*/
#include <iostream>
using namespace std;
class dates
{
  int day, month, year, last;
  int mo[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

public:
  int key;
  dates() {}
  dates(int d, int m, int y)
  {
    day = d;
    month = m;
    year = y;
  }
  void outPut();
  dates operator+(dates d);

  void Month();
  void Day();
  int valid();
};
void dates::outPut()
{
  cout << "Result is = " << day << "/" << month << "/" << year << endl;
}

//validty
void dates::Month()
{
  if (month > 0 && month <= 12)
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    {
      last = 31;
      Day();
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      last = 30;
      Day();
    }
    else if (month == 2)
    {
      if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
      {
        last = 29;
        Day();
      }
      else
      {
        last = 28;
        Day();
      }
    }
  }
  else
    cout << "Invalid Date";
}
//Day
void dates::Day()
{
  if (day > 0 && day <= last)
  {
    valid();
  }
  else
    cout << "Invalid Date";
}

int dates::valid()
{
  key = 1;
  return key;
  
}

dates dates::operator+(dates d)
{
  dates m;
  int i;
  m.day = day + d.day;
  i = month - 1;
  m.month = 0;
  m.year = year;
  if (i == 1)
  {
    if ((m.year % 4 == 0) && (m.year % 100 != 0) || (m.year % 400 == 0))
    {
      mo[1] = 29;
    }
  }
  if ((m.day - mo[i]) > 0)
  {
    while ((m.day - mo[i]) > 0)
    {
      if ((m.year % 4 == 0) && (m.year % 100 != 0) || (m.year % 400 == 0))
      {
        mo[1] = 29;
      }
      m.day = m.day - mo[i];
      month++;
      i++;
      if ((month - 1) % 12 == 0)
      {
        i = 0;
        m.year++;
      }
    }
    if (month > 12)
    {
      if (month % 12 == 0)
        m.month = 12;
      else
        m.month = month % 12;
    }
    else
      m.month = month;
    i++;
  }
  else
  {
    m.month = month;
    m.year = year;
  }

  return m;
}

int main()
{
  int d, m, y, n;
  cout << "Enter the date\n";
  cin >> d >> m >> y;
  cout << "Enter the day to be added \n";
  cin >> n;
  dates d1(d, m, y), d2(n, 0, 0), d3;
  d1.Month();
  if (d1.key == 1)
  {
    d3 = d1 + d2;
    d3.outPut();
  }

  return 0;
}
