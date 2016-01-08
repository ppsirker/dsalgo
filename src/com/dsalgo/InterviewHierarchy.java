/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-longest-interviewer-chain.html
*/

package com.dsalgo;
import java.util.ArrayList;
import java.util.List;

public class InterviewHierarchy
{
	public static void main(String[] args)
	{
		Employee ceo = new Employee("ceo");
		Employee director1 = new Employee("director1");
		Employee director2 = new Employee("director2");
		Employee director3 = new Employee("director3");
		Employee manager1 = new Employee("manager1");
		Employee manager2 = new Employee("manager2");
		Employee manager3 = new Employee("manager3");
		Employee employee1 = new Employee("employee1");
		Employee employee2 = new Employee("employee2");
		Employee employee3 = new Employee("employee3");
		director1.addInterviewer(ceo);
		director2.addInterviewer(ceo).addInterviewer(director1);
		director3.addInterviewer(director1).addInterviewer(director2);
		manager1.addInterviewer(ceo).addInterviewer(director1)
				.addInterviewer(director2).addInterviewer(director3);
		manager2.addInterviewer(director2).addInterviewer(director3)
				.addInterviewer(manager1);
		manager3.addInterviewer(director1).addInterviewer(director2)
				.addInterviewer(manager2).addInterviewer(manager1);
		employee1.addInterviewer(director1).addInterviewer(director2)
				.addInterviewer(manager3).addInterviewer(manager2);
		employee2.addInterviewer(manager3).addInterviewer(manager2)
				.addInterviewer(manager1).addInterviewer(employee1);
		employee3.addInterviewer(employee1).addInterviewer(employee2)
				.addInterviewer(director3).addInterviewer(manager2);

		List<Employee> result = findLongestInterviewChain(employee2);
		System.out.println("Longest interview chain of " + employee2.getName());
		for (Employee employee : result)
			System.out.print(employee.getName() + ", ");
	}

	private static List<Employee> findLongestInterviewChain(Employee employee)
	{
		int maxLength = -1;
		List<Employee> longestPath = new ArrayList<InterviewHierarchy.Employee>();
		for (Employee interviewer : employee.getInterviewers())
		{
			List<Employee> path = findLongestInterviewChain(interviewer);
			if (path.size() > maxLength)
			{
				maxLength = path.size();
				longestPath = path;
			}
		}
		longestPath.add(0, employee);
		return longestPath;
	}

	private static class Employee
	{
		private List<Employee> interviewers;
		private String name;

		public Employee(String name)
		{
			this.name = name;
			interviewers = new ArrayList<Employee>();
		}

		public String getName()
		{
			return name;
		}

		public List<Employee> getInterviewers()
		{
			return interviewers;
		}

		public Employee addInterviewer(Employee employee)
		{
			this.interviewers.add(employee);
			return this;
		}
	}
}
