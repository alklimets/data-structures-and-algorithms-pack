<h1>Euclid's Algorithm for Finding the Largest Square in a Rectangle</h1>

<h2>Introduction</h2>
<p>
    Euclid's algorithm is a method used to find the greatest common divisor (GCD) of two numbers. In the context of geometry, 
    this algorithm can be applied to determine the largest square that can fit into a given rectangle without leaving any leftover space.
</p>

<h2>How It Works</h2>
<p>
    Given a rectangle with dimensions <strong>a × b</strong>, the goal is to divide the rectangle into squares of the largest possible size.
    The side length of the largest square is the greatest common divisor (GCD) of the two dimensions <strong>a</strong> and <strong>b</strong>.
</p>
<p>
    The Euclidean algorithm works by repeatedly dividing the larger number by the smaller number, finding the remainder, and
    repeating the process until the remainder is zero. The last non-zero remainder is the GCD, which represents the side length
    of the largest square that can tile the rectangle.
</p>

<h2>Algorithm Steps</h2>
<ol>
    <li>Start with two numbers <strong>a</strong> and <strong>b</strong> (where <strong>a > b</strong>).</li>
    <li>Divide <strong>a</strong> by <strong>b</strong> and find the remainder <strong>r</strong>.</li>
    <li>Replace <strong>a</strong> with <strong>b</strong> and <strong>b</strong> with the remainder <strong>r</strong>.</li>
    <li>Repeat the process until the remainder is zero. The non-zero remainder at this point is the GCD, which is the side of the largest square.</li>
</ol>

<h2>Example</h2>
<p class="example">
    Find the largest square that can fit into a 48 × 18 rectangle using Euclid’s algorithm.
</p>
<div class="code">
    1. Start with 48 and 18.<br>
    2. 48 ÷ 18 = 2 (remainder 12).<br>
    3. Replace 48 with 18, and 18 with 12.<br>
    4. 18 ÷ 12 = 1 (remainder 6).<br>
    5. Replace 18 with 12, and 12 with 6.<br>
    6. 12 ÷ 6 = 2 (remainder 0).<br>
    7. The GCD is 6.<br>
</div>
<p>
    The largest square that can fit into a 48 × 18 rectangle has a side length of 6.
</p>

<h2>Conclusion</h2>
<p>
    By applying Euclid’s algorithm, we can efficiently determine the largest square that can fit into any rectangle. This is particularly useful in scenarios where you need to tile a rectangular area with squares, ensuring no leftover space.
</p>