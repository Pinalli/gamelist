import React, { useState, useEffect } from 'react';
import CategoryList from './components/CategoryList';

const App = () => {
    const [categories, setCategories] = useState({});

    useEffect(() => {
        // Buscar os dados dos jogos da API do backend
        const fetchGameData = async () => {
            const response = await fetch('/api/games');
            const data = await response.json();

            // Organizar os jogos por categoria
            const categorizedGames = data.reduce((acc, game) => {
                if (!acc[game.category]) {
                    acc[game.category] = [];
                }
                acc[game.category].push(game);
                return acc;
            }, {});

            setCategories(categorizedGames);
        };

        fetchGameData();
    }, []);

    return (
        <div className="container mx-auto p-4">
            <h1 className="text-3xl font-bold mb-4">Listagem de Jogos</h1>
            <CategoryList categories={categories} />
        </div>
    );
};

export default App;