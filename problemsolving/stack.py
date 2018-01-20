class Stack:
	def __init__(self):
		self.items = []

	def isEmpty(self):
		return len(self.items) == 0
		
	def size(self):
		return len(self.items)
		
	def push(self, item):
		self.items.append(item)
		
	def pop(self):
		return self.items.pop()
		
	def peek(self):
		return self.items[self.size() - 1]


s = Stack();
print("Stack is empty: %s" %(s.isEmpty()))
s.push(4)
print("Size is %d" %(s.size()))
s.push("Carmen")
print(s.pop())
print("Size is %d" %(s.size()))
s.push("Teodor")
print(s.peek())
