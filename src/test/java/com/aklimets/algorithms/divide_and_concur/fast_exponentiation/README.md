<h1>Exponentiation by Squaring</h1>
    <p>
        <strong>Exponentiation by Squaring</strong> is an efficient algorithm for computing the power of a number. Instead of multiplying the base repeatedly, it breaks down the exponentiation process into smaller parts using the following rules:
    </p>
    <ul>
        <li>If the exponent is even, <code>a^b = (a^{b/2})^2</code>.</li>
        <li>If the exponent is odd, <code>a^b = a * a^{b-1}</code>.</li>
    </ul>
    <p>This method reduces the number of operations, making the computation much faster, especially for large exponents. The algorithm works in logarithmic time, <code>O(log b)</code>, instead of linear time, <code>O(b)</code>, for the naive method.</p>
    <h2>Examples:</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Base</th>
                <th>Power</th>
                <th>Result</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>2</td><td>3</td><td>8</td></tr>
        </tbody>
    </table>
    <h3>Steps for 2<sup>3</sup>:</h3>
    <ul>
        <li>Step 1: ( 2^3 = 2 * 2^2 ) (since 3 is odd)</li>
        <li>Step 2: ( 2^2 = 4 )</li>
        <li>Step 3: ( 2^3 = 2 * 4 = 8 )</li>
    </ul>

<table border="1">
        <thead>
            <tr>
                <th>Base</th>
                <th>Power</th>
                <th>Result</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>5</td><td>6</td><td>15625</td></tr>
        </tbody>
    </table>
    <h3>Steps for 5<sup>6</sup>:</h3>
    <ul>
        <li>Step 1: ( 5^6 = (5^3)^2 ) (since 6 is even)</li>
        <li>Step 2: ( 5^3 = 5 * 5^2 ) (since 3 is odd)</li>
        <li>Step 3: ( 5^2 = 25 )</li>
        <li>Step 4: ( 5^3 = 5 * 25 = 125 )</li>
        <li>Step 5: ( 5^6 = 125^2 = 15625 )</li>
    </ul>