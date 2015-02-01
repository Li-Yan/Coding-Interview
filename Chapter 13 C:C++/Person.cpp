#include <iostream>
#include <string>
using namespace std;

#define NAME_SIZE 20

class Person {
	int id;
	char name[NAME_SIZE];

public:
	virtual void aboutMe() {
		cout << "I am a person." << endl;
	}

	virtual bool addCourse(string s) {
		cout << "Added course " << s << " to person." << endl;
		return true;
	}

	virtual ~Person() {
		cout << "Deleting a person." << endl;
	}
};

class Student : public Person {
public:
	void aboutMe() {
		cout << "I am a student." << endl;
	}

	bool addCourse(string s) {
		cout << "Added course " << s << " to student." << endl;
		return true;
	}

	~Student() {
		cout << "Deleting a student." << endl;
	}
};

int main() {
	Person * p = new Person();
	p->aboutMe();
	p->addCourse("Cloud Computing");
	delete p;

	return 0;
}