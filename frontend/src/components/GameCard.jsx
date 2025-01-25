import React from 'react';

const GameCard = ({ game }) => {
    return (
        <div className="bg-white shadow-md rounded-lg overflow-hidden">
            <img src={game.image} alt={game.title} className="w-full h-48 object-cover" />
            <div className="p-4">
                <h3 className="text-lg font-bold">{game.title}</h3>
                <p className="text-gray-600">{game.year}</p>
                <p className="mt-2">{game.description}</p>
            </div>
        </div>
    );
};

export default GameCard;