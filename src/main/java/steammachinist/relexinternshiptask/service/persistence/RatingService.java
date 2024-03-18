package steammachinist.relexinternshiptask.service.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.relexinternshiptask.dto.RatingDto;
import steammachinist.relexinternshiptask.dto.request.AddRatingRequest;
import steammachinist.relexinternshiptask.dto.response.RatingListResponse;
import steammachinist.relexinternshiptask.entity.Rating;
import steammachinist.relexinternshiptask.entity.User;
import steammachinist.relexinternshiptask.mapper.RatingMapper;
import steammachinist.relexinternshiptask.repository.RatingRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

    private final RatingRepository repository;
    private final RatingMapper mapper;
    private final UserService userService;

    public Rating add(Rating rating) {
        return repository.save(rating);
    }

    public RatingDto add(RatingDto ratingDto) {
        return mapper.toDto(
                repository.save(mapper.toEntity(ratingDto)));
    }

    public RatingDto add(AddRatingRequest addRatingRequest) {
        User user = userService.getByEmail(addRatingRequest.getEmployeeEmail());
        LocalDate date = LocalDate.parse(addRatingRequest.getDate(), formatter);
        Rating rating = new Rating(user, date, addRatingRequest.getPoints());
        return mapper.toDto(repository.save(rating));
    }

    public List<RatingListResponse> getAllResponse() {
        List<Rating> ratings = repository.findAll();
        return ratings.stream()
                .map(rating -> new RatingListResponse(
                        rating.getUser().getEmail(),
                        rating.getDate().format(formatter),
                        rating.getPoints()))
                .collect(Collectors.toList());
    }
}
