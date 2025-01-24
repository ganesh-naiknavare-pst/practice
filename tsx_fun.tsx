import React, { useState, useCallback } from 'react';
import styled from 'styled-components';

interface FunctionDemo {
  name: string;
  function: (...args: any[]) => any;
  defaultInput: string;
  description: string;
}

interface ResultProps {
  success: boolean;
}

const Container = styled.div`
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
`;

const FunctionCard = styled.div`
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  margin: 10px 0;
  background: #f9f9f9;
`;

const Input = styled.input`
  padding: 8px;
  margin: 10px 0;
  width: 200px;
  border: 1px solid #ddd;
  border-radius: 4px;
`;

const Button = styled.button`
  padding: 8px 15px;
  background: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 10px;
  
  &:hover {
    background: #0056b3;
  }
`;

const Result = styled.div<ResultProps>`
  margin-top: 10px;
  padding: 10px;
  background: ${props => props.success ? '#d4edda' : '#f8d7da'};
  border-radius: 4px;
  color: ${props => props.success ? '#155724' : '#721c24'};
`;

// Utility Functions
const utilityFunctions: FunctionDemo[] = [
  {
    name: "Palindrome Check",
    function: (str: string): boolean => {
      const clean = str.toLowerCase().replace(/[^a-zA-Z0-9]/g, '');
      return clean === clean.split('').reverse().join('');
    },
    defaultInput: "A man, a plan, a canal: Panama",
    description: "Checks if a string is a palindrome"
  },
  {
    name: "Factorial",
    function: (n: number): number => {
      if (n < 0) throw new Error("Negative numbers not allowed");
      if (n <= 1) return 1;
      return n * utilityFunctions[1].function(n - 1);
    },
    defaultInput: "5",
    description: "Calculates factorial of a number"
  },
  {
    name: "Prime Check",
    function: (num: number): boolean => {
      if (num <= 1) return false;
      for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
      }
      return true;
    },
    defaultInput: "17",
    description: "Checks if a number is prime"
  },
  {
    name: "String Reverse",
    function: (str: string): string => {
      return str.split('').reverse().join('');
    },
    defaultInput: "hello world",
    description: "Reverses a string"
  },
  {
    name: "Power Calculator",
    function: (base: number, exp: number): number => {
      if (exp === 0) return 1;
      if (exp < 0) return 1 / utilityFunctions[4].function(base, -exp);
      return base * utilityFunctions[4].function(base, exp - 1);
    },
    defaultInput: "2,3",
    description: "Calculates power of a number"
  }
];

// Main Component
const FunctionDemonstrator: React.FC = () => {
  const [results, setResults] = useState<Map<string, { result: string; success: boolean }>>(
    new Map()
  );
  const [inputs, setInputs] = useState<Map<string, string>>(
    new Map(utilityFunctions.map(f => [f.name, f.defaultInput]))
  );

  const handleInputChange = useCallback((functionName: string, value: string) => {
    setInputs(prev => new Map(prev).set(functionName, value));
  }, []);

  const executeFunction = useCallback((func: FunctionDemo) => {
    try {
      const input = inputs.get(func.name) || '';
      let result;
      
      if (func.name === "Power Calculator") {
        const [base, exp] = input.split(',').map(Number);
        result = func.function(base, exp);
      } else {
        result = func.function(func.name.includes("Check") ? input : Number(input));
      }

      setResults(prev => new Map(prev).set(func.name, {
        result: String(result),
        success: true
      }));
    } catch (error) {
      setResults(prev => new Map(prev).set(func.name, {
        result: error.message,
        success: false
      }));
    }
  }, [inputs]);

  return (
    <Container>
      <h1>Function Demonstrator</h1>
      {utilityFunctions.map(func => (
        <FunctionCard key={func.name}>
          <h3>{func.name}</h3>
          <p>{func.description}</p>
          <Input
            value={inputs.get(func.name) || ''}
            onChange={(e) => handleInputChange(func.name, e.target.value)}
            placeholder="Enter input"
          />
          <Button onClick={() => executeFunction(func)}>
            Execute
          </Button>
          {results.get(func.name) && (
            <Result success={results.get(func.name)?.success || false}>
              Result: {results.get(func.name)?.result}
            </Result>
          )}
        </FunctionCard>
      ))}
    </Container>
  );
};

export default FunctionDemonstrator;