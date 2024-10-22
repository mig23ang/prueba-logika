import React, { useEffect, useState } from 'react';

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [error, setError] = useState(null); // Para manejar errores

    useEffect(() => {
        fetch('http://localhost:8080/v1/productos', {
            method: 'GET', // Método de la solicitud
            headers: {
                'Content-Type': 'application/json',
                'username': 'miguel', // Username hardcodeado
                'password': '123',     // Password hardcodeado
            },
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data) => setProducts(data))
            .catch((error) => {
                console.error('Error fetching products:', error);
                setError('Error fetching products');
            });
    }, []); // Se ejecuta una vez al montar el componente

    return (
        <div>
            <h2>Lista de Productos</h2>
            <ul>
                {products.map((product) => (
                    <li key={product.id}>{product.nombre} - ${product.precio}</li>
                ))}
            </ul>
        </div>

    );
};

export default ProductList;
