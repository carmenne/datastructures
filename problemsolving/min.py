import math
import time

# Quadratic implementation
def min_quadratic(numbers):
    min_num = numbers[0]
    for num1 in numbers:
        min_num = min(min_num, num1)
        for num2 in numbers:
            min_num = min(min_num, num2)
    return min_num        
    
# Linear implementation            
def min_linear(numbers):
    min_num = numbers[0]
    for num in numbers:
        min_num = min(min_num, num)
    return min_num    
        
        
numbers = range(1, 10000)

start_quadratic = time.time()
min1 = min_quadratic(numbers)
end_quadratic = time.time()
print("Quadratic: %d in %d " %(min1, end_quadratic - start_quadratic))

start_linear = time.time()
min1 = min_linear(numbers)
end_linear = time.time()
print("Linear: %d in %d " %(min1, end_linear - start_linear))
