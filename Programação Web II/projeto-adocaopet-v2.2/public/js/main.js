async function loadAnimals() {
  const res = await fetch('/api/animals');
  const animals = await res.json();
  const container = document.getElementById('animals');
  if(!animals || animals.length === 0) {
    container.innerHTML = '<p>Nenhum animal disponível ainda. Seja o primeiro a cadastrar!</p>';
    return;
  }

  container.innerHTML = animals.map(a => `
    <div class="card">
      <img src="${a.photo ? '/uploads/' + a.photo : 'https://via.placeholder.com/150'}" alt="${a.name}">
      <h3>${a.name || 'Sem nome'}</h3>
      <p>${a.species || ''} • ${a.age || 'idade não informada'}</p>
      <p>${a.bio || ''}</p>
      <p>Status: ${a.adopted ? 'Adotado' : 'Disponível'}</p>
    </div>
  `).join('');
}

document.addEventListener('DOMContentLoaded', () => {
  loadAnimals();
});
