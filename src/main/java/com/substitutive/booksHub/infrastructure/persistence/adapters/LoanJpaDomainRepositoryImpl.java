package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.exceptions.LoanNotFoundException;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import com.substitutive.booksHub.infrastructure.persistence.mappers.LoanMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.LoanJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoanJpaDomainRepositoryImpl implements LoanDomainRepository {

    private final LoanJpaRepository loanJpaRepository;

    @Override
    public Loan save(Loan loan) {
        var loanEntity = LoanMapper.toEntity(loan);
        var savedLoan = loanJpaRepository.save(loanEntity);
        return LoanMapper.toDomain(savedLoan);
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return loanJpaRepository.findById(id).map(LoanMapper::toDomain);
    }

    @Override
    public List<Loan> findAll() {
        return loanJpaRepository.findAll().stream().map(LoanMapper::toDomain).toList();
    }

    @Override
    public List<Loan> findAllByUserId(Long userId) {
        return loanJpaRepository.findAllByUserEntity_Id(userId).stream().map(LoanMapper::toDomain).toList();
    }

    @Override
    public List<Loan> findAllByBookId(Long bookId) {
        return loanJpaRepository.findAllByBooks_Id(bookId).stream().map(LoanMapper::toDomain).toList();
    }

    @Override
    public Loan update(Loan loan) {
        var entity = LoanMapper.toEntity(loan);
        var saved = loanJpaRepository.save(entity);
        return LoanMapper.toDomain(saved);
    }

    @Override
    public void delete(Long id) {
        loanJpaRepository.deleteById(id);
    }
}
