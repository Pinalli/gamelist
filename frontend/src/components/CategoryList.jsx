import React from 'react';
import GameList from './GameList';

const CategoryList = ({ categories }) => {
    return (
        <div>
            {Object.keys(categories).map((category) => (
                <div key={category} className="mb-8">
                    <h2 className="text-2xl font-bold mb-4">{category}</h2>
                    <GameList games={categories[category]} />
                </div>
            ))}
        </div>
    );
};

export default CategoryList;