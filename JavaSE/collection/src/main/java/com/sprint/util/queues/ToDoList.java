package com.sprint.util.queues;

import java.util.*;
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
	public static class ToDoItem implements Comparable<ToDoItem> {
		private char primary;
		private int secondary;
		private String item;

		public ToDoItem(String item, int secondary, char primary) {
			this.item = item;
			this.secondary = secondary;
			this.primary = primary;
		}

		public int compareTo(ToDoItem arg) {
			if (primary > arg.primary) {
				return 1;
			} 

			if (primary == arg.primary) {
				if (secondary > arg.secondary) 
					return 1;
				else if (secondary == arg.secondary)
					return 0;
			}
				return -1;
		} 

		public String toString() {
			return Character.toString(primary) + secondary + ":" + item;
		}
	}

	public void add(String item, int secondary, char primary) {
		super.add(new ToDoItem(item, secondary, primary));
	}
}
