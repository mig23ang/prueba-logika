// src/components/ProductForm.js
import React, { useState } from 'react';
import './ProductForm.css'; // Importamos el archivo CSS para los estilos

const ProductForm = () => {
    const [nombre, setNombre] = useState('');
    const [precio, setPrecio] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [stock, setStock] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState(''); // Estado para mensajes
    const [error, setError] = useState(''); // Estado para errores

    const handleSubmit = (event) => {
        event.preventDefault();
        const productData = { nombre, precio, descripcion, stock };

        fetch('http://localhost:8080/v1/productos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'username': username, 
                'password': password,
            },
            body: JSON.stringify(productData),
        })
            .then((response) => {
                if (response.ok) {
                    setMessage('Producto creado exitosamente!');
                    setError(''); // Limpiar mensajes de error
                    // Limpiar el formulario
                    setNombre('');
                    setPrecio('');
                    setDescripcion('');
                    setStock('');
                } else {
                    setError('Error creando producto');
                    setMessage(''); // Limpiar mensajes de éxito
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                setError('Error en la conexión al servidor');
                setMessage(''); // Limpiar mensajes de éxito
            });
    };

    return (
        <form onSubmit={handleSubmit} className="product-form">
            <h2>Crear Producto</h2>
            <input
                type="text"
                placeholder="Nombre"
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
                required
            />
            <input
                type="number"
                placeholder="Precio"
                value={precio}
                onChange={(e) => setPrecio(e.target.value)}
                required
            />
            <textarea
                placeholder="Descripción"
                value={descripcion}
                onChange={(e) => setDescripcion(e.target.value)}
                required
            />
            <input
                type="number"
                placeholder="Stock"
                value={stock}
                onChange={(e) => setStock(e.target.value)}
                required
            />
            <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
            />
            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
            />
            <button type="submit">Crear Producto</button>
            {message && <p className="success-message">{message}</p>}
            {error && <p className="error-message">{error}</p>}
        </form>
    );
};

export default ProductForm;
